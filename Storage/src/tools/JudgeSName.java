package tools;

public class JudgeSName {
//	public static void main(String[] args) {
//		//boolean a = judgeSName("TXa100Sx10-TXa120Sx30");
//		//boolean b = judgeSName("X100-T120");
//		//System.out.println(a);
//		//System.out.println(b);
//		//System.out.println("aa");
//	}
	
	public static boolean judgeSName(String pSN){
		String serialLong = "";
		if(!pSN.contains("~")) {
			return true;
		}
		String[] serialNum = pSN.split("~");
		String[] qty = pSN.split("~");
		//取得輸入去掉符號後的字串
		String fullname = "";
		for(String a : qty) {
			fullname += a;
		}
		if(qty[0].length() != qty[1].length()) {
			return false;
		}
		//過濾掉數字以外的字元
		qty = fullname.split("\\D+");
		for(String i : qty) {
			serialLong += i;
		}
		if(serialLong.length() == fullname.length()) {
			int a = Integer.parseInt(serialNum[0]);
			int b = Integer.parseInt(serialNum[1]);
			if(a < b) {
				return true;
			}else {
				return false;
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
			//將qty資料中的空字串("")除去，留下數字資料
			for(int i = 0; i < qty.length; i++) {
				if(!"".equals(qty[i])) {
					name[count] = qty[i];
					count++;
				}
			}
			
			if(Integer.parseInt(name[1]) <= Integer.parseInt(name[0])) {
				return false;
			}
			
			String t1 = serialNum[0].replaceAll("[^a-zA-Z]", "");
			String t2 = serialNum[1].replaceAll("[^a-zA-Z]", "");
			if(!t1.equals(t2)) {
				return false;
			}
			
			return true;
		}
		
		//輸入編號型態，例:SD100TY100~SD200TY200
		if(name.length == 4) {
			//將qty資料中的空字串("")除去，留下數字資料
			for(int i = 0; i < qty.length; i++) {
				if(!"".equals(qty[i])) {
					name[count] = qty[i];
					count++;
				}
			}
			
			if(Integer.parseInt(name[2]) <= Integer.parseInt(name[0]) || Integer.parseInt(name[3]) <= Integer.parseInt(name[1])) {
				return false;
			}
			if((Integer.parseInt(name[2]) - Integer.parseInt(name[0])) != (Integer.parseInt(name[3]) - Integer.parseInt(name[1]))) {
				return false;
			}
			
			char firstNum1 = name[0].charAt(0);
			int firstNumIndex1 = serialNum[0].indexOf(firstNum1);
			String tA1 = serialNum[0].substring(0, firstNumIndex1);
			String tB1 = serialNum[0].substring(firstNumIndex1, serialNum[0].length()).replaceAll("[^a-zA-Z]", "");
			
			char firstNum2 = name[2].charAt(0);
			int firstNumIndex2 = serialNum[1].indexOf(firstNum2);
			String tA2 = serialNum[1].substring(0, firstNumIndex2);
			String tB2 = serialNum[1].substring(firstNumIndex2, serialNum[1].length()).replaceAll("[^a-zA-Z]", "");
			if(!tA1.equals(tA2) || !tB1.equals(tB2)) {
				return false;
			}
			
		}
		
		return true;
	}
}
