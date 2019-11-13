package idv.zjh.lambda;

/**
 * lambda的基礎 四種寫法，以及Interface註解
  *  四種基礎寫法裡面，以第一種和第四種最常見
 * @author zjh
 * 
 */
public class Lambda1Basic {
	
	public static void main(String[] args) {
		Lambda1Basic lam = new Lambda1Basic();
		
		//第一種方法
		ILambda demo1 = n -> n + n;
		System.out.println("demo1:" +demo1.add(5));
		
		// second method
		ILambda demo2 = (n) -> n + n;
		System.out.println("demo2:"+demo2.add(5));

		// third method
		ILambda demo3 = (int n) -> n + n;
		System.out.println("demo3:"+demo3.add(5));
		
		// four method
		ILambda demo4 = (int num1) -> {
			System.out.println("傳入的參數:"+num1+"  +  1 後回傳");
			return ++num1;
		};
		System.out.println("demo4:"+demo4.add(6));
		
		//Other Example
		IDemo2 demo5 = (num1,num2) -> {
			return num1 + num2;
		};
		System.out.println("demo5:"+demo5.add(5,6));
	}
}

/**
 * @FunctionalInterface 註解表示這是一個函數介面，但不註解也行，基本上函數接口的目的就是接口裡面只有一個方法
 * @author zjh
 */
@FunctionalInterface
interface ILambda {
	int add(int i);
}

/**
 * 這就是不加註解的函數接口
 * @author zjh
 */
interface IDemo2 {
	int add(int i, int i2);
}