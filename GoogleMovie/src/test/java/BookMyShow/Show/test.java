package BookMyShow.Show;

import java.util.Random;

import org.openqa.selenium.By;

public class test {
	public int getPrimeNo(){
//		boolean b=true;
		
//		for(int i=2;i<no;i++){
//			if(no%i==0){
//				b=false;
//			}else{
//				getPrimeNo();
//			}
//		}
		//li[@id='pop_+no+']
//		System.out.println(b);
		int a[]={2, 3, 5, 7};
		Random r=new Random();
		int num=0;
		int rNo= r.nextInt(a.length-1);
		for (int i = 0; i < a.length; i++) {
			num=a[rNo];

		}
		return num;
	}
	public static void main(String[] args) {
		
		test t=new test();
		System.out.println(t.getPrimeNo());
		
	}
//	public void getSelectOrime()
//	{
//		 int num = objPojo.getWrapper().getPrimeNo();
//		objPojo.getDriver().findElement(By.xpath("//li[@id='pop_"+num+"']"));
//	objPojo.getWrapper().click(BtnSelectSeat);
//	
//	

}
