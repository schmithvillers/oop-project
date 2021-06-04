
	public class Member {
		private String acc,amt;
		
		public Member() {
			super();
		}
		public Member(String amt)
		{
			super();
			this.amt=amt;
		}
		public Member(String amt,String acc)
		{
			super();
			this.amt=amt;
			this.acc=acc;
		}
		
		public String getAmt() {
			return amt;
		
		}
		
		public void setAmt(String amt) {
			this.amt=amt;
		}
		
		public String getAcc() {
			return acc;
		}
		
		public void setAcc(String acc) {
			this.acc = acc;
		}
	
	}
