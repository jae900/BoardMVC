package kr.itedu.boardmvc.common;

public class Utils {
	//정수 파라미터 값 가져오기(이상 있으면-1)
	public static int getParamInt(String s) {
		int r = -1;
		if(s != null && !s.equals("")){
			try {
				r=Integer.parseInt(s);
			} catch(Exception e) {}
		}
		return r;
	}
}
