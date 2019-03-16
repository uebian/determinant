import java.util.*;

public class Main
{
	static int n;
	static double da=0;
	static double data[][];
	public static void main(String[] args)
	{
		System.out.println("Input N");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		data=new double[n][n];
		for (int i=0;i < n;i++)
		{
			for (int j=0;j < n;j++)
			{
				data[i][j] = input.nextDouble();
			}
		}
		dg(1, 0, new Stack<Integer>());
		System.out.println(da);
	}
	public static void dg(double ans, int line, Stack<Integer> yg)
	{
		for (int i=0;i < n;i++)
		{
			if(line==n)
			{
				if(nxs(yg)%2==0)
				{
					da=da+ans;
				}else{
					da=da-ans;
				}
				break;
			}else if (!ex(i,yg))
			{
				yg.add(i);
				dg(ans * data[line][i], line + 1, yg);
				yg.pop();
			}
		}
	}
	public static boolean ex(int num, List<Integer> arr)
	{
		for (Integer nu:arr)
		{
			if (nu == num)
			{
				return true;
			}
		}
		return false;
	}
	public static int nxs(List<Integer> data)
	{
		int xs=0;
		for (int i=0;i < data.size();i++)
		{
			for (int j=i + 1;j < data.size();j++)
			{
				if (data.get(j) < data.get(i))
				{
					xs++;
				}
			}
		}
		return xs;
	}
}
