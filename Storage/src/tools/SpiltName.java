package tools;

public class SpiltName {

	public static void main(String[] args) {
//		String[] a = spiltName("T0092~T0103");
//		for(String i : a) {
//			System.out.println(i);
//		}
		
//		String[] b = spiltName("T0097S009~T0100S012");
//		for(String i : b) {
//			System.out.println(i);
//		}
//		
//		String[] c = spiltName("123~125");
//		for(String i : c) {
//			System.out.println(i);
//		}
		
		String[] d = spiltName("A-21T0100~A-24T0103");
		for(String i : d) {
			System.out.println(i);
		}
		
//		System.out.println(a.length);

	}
	
	public static String[] spiltName(String serialNum) {
		serialNum = serialNum.trim();
		if (serialNum.contains("~")) {
			SpiltName t = new SpiltName();
			if(serialNum.indexOf("-") >= 0) {
				
			}
			return t.getQTY(serialNum.split("~"));
		}
		if (serialNum.contains(",")) {
			return serialNum.split(",");
		}
		return new String[] { serialNum };
	}
	
	private String[] getQTY(String[] serialNum) {
		String[] qty = serialNum;
		String serialLong = "";
		//取得輸入去掉符號後的字串
		String fullname = "";
		for(String a : qty) {
			fullname += a;
		}
		
		//過濾掉數字以外的字元
		qty = fullname.split("\\D+");
		for(String i : qty) {
			serialLong += i;
		}
		if(serialLong.length() == fullname.length()) {
			int a = Integer.parseInt(serialNum[0]);
			int b = Integer.parseInt(serialNum[1]);
			qty = new String[(b - a) + 1];
			for(int i = 0; a <= b; i++) {
				qty[i] = String.valueOf(a);
				a++;
			}
			
		}
		//計算有多少筆數字資料，來判斷輸入編號型態，例:(SD100~SD200)或(SD100TY100~SD200TY200)
		int count = 0;
		for(int i = 0; i < qty.length; i++) {
			if(!"".equals(qty[i])) {
				count++;
			}
		}
		
		//判斷完型態，建立ARRAY大小
		String[] name = new String[count];
		//ARRAY建立完畢，先將計數歸零，以便數字資料存入name[]
		count = 0;
		
		//輸入編號型態為，例:SD100~SD200
		if(name.length == 2) {
			int[] numL = new int[2];
			//將qty資料中的空字串("")除去，留下數字資料
			for(int i = 0; i < qty.length; i++) {
				if(!"".equals(qty[i])) {
					name[count] = qty[i];
					numL[count] = qty[i].length();
					count++;
				}
			}

			//取得資料比數
			int sum = Integer.parseInt(name[1]) - Integer.parseInt(name[0]) + 1;
			//定義陣列資料大小
			qty = new String[sum];
			
			//取得開頭數字
			//char firstNum = name[0].charAt(0);
			//取得開頭數字在輸入資料中的位置
			//int firstNumIndex = fullname.indexOf(firstNum);
			//儲存英文編號
			//String title = fullname.substring(0, firstNumIndex);
			String title = serialNum[0].replaceAll("[^a-zA-Z]", "");

			//讓陣列從零開始儲存，之後再回圈後面慢慢往上加，回圈條件使用輸入資料，所以跟這個不用管
			int firstNumIndex = 0;
			//將資料依序存入陣列中
			for(int i = Integer.parseInt(name[0]); i <= Integer.parseInt(name[1]); i++)  {
				if(String.valueOf(i).length() < numL[0]) {
					String num = String.valueOf(i);
					int x = numL[0] - num.length();
					for(int m = 0; m < x; m++) {
						num = "0" + num;
					}
					qty[firstNumIndex] = title + num;
					firstNumIndex++;
				}else {
					qty[firstNumIndex] = title + i;
					firstNumIndex++;
				}
				
			}
		}
		
		//輸入編號型態，例:SD100TY100~SD200TY200
		if(name.length == 4) {
			int[] numL = new int[4];
			//將qty資料中的空字串("")除去，留下數字資料
			for(int i = 0; i < qty.length; i++) {
				if(!"".equals(qty[i])) {
					name[count] = qty[i];
					numL[count] = qty[i].length();
					count++;
				}
			}
			//取得資料比數
			int sum = Integer.parseInt(name[2]) - Integer.parseInt(name[0]) + 1;
			
			//定義陣列資料大小
			qty = new String[sum];
			char firstNum = name[0].charAt(0);
			int firstNumIndex = serialNum[0].indexOf(firstNum);
			String titleA = serialNum[0].substring(0, firstNumIndex);
			String titleB = serialNum[0].substring(firstNumIndex, serialNum[0].length()).replaceAll("[^a-zA-Z]", "");
			
			//讓陣列從零開始儲存，之後再回圈後面慢慢往上加，回圈條件使用輸入資料，所以跟這個不用管
			firstNumIndex = 0;
			//將資料依序存入陣列中
			for(int i = Integer.parseInt(name[0]), j = Integer.parseInt(name[1]); i <= Integer.parseInt(name[2]); i++, j++)  {
				if(String.valueOf(i).length() < numL[0] || String.valueOf(j).length() < numL[1]) {
					String num1 = String.valueOf(i);
					String num2 = String.valueOf(j);
					if(String.valueOf(i).length() < numL[0]) {
						int x = numL[0] - String.valueOf(i).length();
						for(int m = 0; m < x; m++) {
							num1 = "0" + num1;
						}
					}
					if(String.valueOf(j).length() < numL[1]) {
						int x = numL[1] - String.valueOf(j).length();
						for(int m = 0; m < x; m++) {
							num2 = "0" + num2;
						}
					}
					qty[firstNumIndex] = titleA + num1 + titleB + num2;
					firstNumIndex++;
				}else {
					qty[firstNumIndex] = titleA + i + titleB + j;
					firstNumIndex++;
				}
				
			}
			
		}
		
		//返回ARRAY
		return qty;
	}
}
