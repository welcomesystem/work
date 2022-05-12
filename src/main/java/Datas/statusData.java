package Datas;

public class statusData {
	private int Stu_id;//学号
	private String Stu_na;//学生姓名
	private int	Sta_1;//教务处报到
	private int	Sta_2;//宿舍报到
	private int	Sta_3;//体检报到
	public int getStu_id() {
		return Stu_id;
	}
	public void setStu_id(int stu_id) {
		Stu_id = stu_id;
	}
	public int getSta_1() {
		return Sta_1;
	}
	public void setSta_1(int sta_1) {
		Sta_1 = sta_1;
	}
	public int getSta_2() {
		return Sta_2;
	}
	public void setSta_2(int sta_2) {
		Sta_2 = sta_2;
	}
	public int getSta_3() {
		return Sta_3;
	}
	public void setSta_3(int sta_3) {
		Sta_3 = sta_3;
	}
	public String getStu_na() {
		return Stu_na;
	}
	public void setStu_na(String stu_na) {
		Stu_na = stu_na;
	}
	
}
