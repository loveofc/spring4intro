package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	private MemberDao memDao;
	private MemberPrinter printer;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		System.out.println("setMemberDao");
		this.memDao = memberDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		System.out.println("MemberPrinter");
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}
