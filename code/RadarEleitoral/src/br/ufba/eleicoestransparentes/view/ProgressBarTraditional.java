package br.ufba.eleicoestransparentes.view;

class ProgressBarTraditional extends Thread {
	
	
	private String message = "";
	private boolean showProgress = true;
	private float progress = 0;
	
	public void run() {
		String anim  = "====================================================================================================";
		String space = "                                                                                                    ";
		while (showProgress) {
			int barSize = (int)progress % anim.length();
			int spaceSize = anim.length() - barSize;
			System.out.print("\r Processing [" + anim.substring(0, barSize) +
			space.substring(0, spaceSize)+ "] ( "+progress+"% )" + message);
			try { Thread.sleep(100); }
			catch (Exception e) {};
		}
	}	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void update(float progress, String message){
		this.progress = progress;
		this.message = message;
		if(message.length() > 100){
			this.message = this.message.substring(0, 99);
		}
	}

	public boolean isShowProgress() {
		return showProgress;
	}
	
	public void finish() {
		this.showProgress = false;
	}
}