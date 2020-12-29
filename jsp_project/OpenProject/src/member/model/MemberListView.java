package member.model;

import java.util.List;

public class MemberListView {
	private int memberTotalCount; // 리스트 출력, 넘버링 역할
	private int memberCountPerPage;
	private List<Member> memberlist;
	private int pageTotalCount;	// 넘버링 표현
	private int firstRow; 
	private int pageNumber;
	
	
	public MemberListView(
			int memberTotalCount
			, int memberCountPerPage
			, List<Member> memberlist
			, int firstRow
			, int pageNumber) {		
		this.memberTotalCount = memberTotalCount;
		this.memberCountPerPage = memberCountPerPage;
		this.memberlist = memberlist;
		this.firstRow = firstRow;
		this.pageNumber = pageNumber;
		calTotalPageCount();
		
	}
	
	private void calTotalPageCount() {
		if(memberTotalCount==0) {
			pageTotalCount=0;
		} else {
		pageTotalCount = memberTotalCount/memberCountPerPage;
		pageTotalCount = memberTotalCount%memberCountPerPage>0 ? pageTotalCount++ : pageTotalCount;
		}
	}

	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getMemberCountPerPage() {
		return memberCountPerPage;
	}

	public List<Member> getMemberlist() {
		return memberlist;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public String toString() {
		return "MemberLlistView [memberTotalCount=" + memberTotalCount + ", memberCountPerPage=" + memberCountPerPage
				+ ", memberlist=" + memberlist + ", pageTotalCount=" + pageTotalCount + ", firstRow=" + firstRow
				+ ", pageNumber=" + pageNumber + "]";
	}
	
	
	
	
	
	
}
