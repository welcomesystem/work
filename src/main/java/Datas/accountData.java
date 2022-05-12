package Datas;

public class accountData {//账号数据
	private int Acc_id;//账号
	private String Acc_passwd;//密码
	private int Acc_access;//权限
	public int getAcc_id() {
		return Acc_id;
	}
	public void setAcc_id(int acc_id) {
		Acc_id = acc_id;
	}
	public String getAcc_passwd() {
		return Acc_passwd;
	}
	public void setAcc_passwd(String acc_passwd) {
		Acc_passwd = acc_passwd;
	}
	public int getAcc_access() {
		return Acc_access;
	}
	public void setAcc_access(int acc_access) {
		Acc_access = acc_access;
	}
}
