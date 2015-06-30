package br.ufba.eleicoestransparentes.view;

import java.util.Stack;

import br.ufba.eleicoestransparentes.util.Util;

class ProgressBarTraditional extends Thread {
	
	private class AverageMobile{
		private Stack<Float> times = new Stack<Float>();
		private float average = 0, total = 0;
		private int windowSize;
		public AverageMobile(int windowSize){
			this.windowSize = windowSize;
		}
		
		public float getAverage(){
			return average;
		}
		
		public void addTime(float time){
			times.push(time);
			total += time;
			if(times.size() > windowSize){
				total -= times.remove(0);
			}
			average = total / times.size();
		}

		public float getTotal() {
			return total;
		}
		
	}
	
	
	private String message = "";
	private boolean showProgress = true;
	private float progress = 0;
	private float taskProgress = 0;
	private float estimatedTimeInMilis = 0;
	
	public void run() {
		String anim  = "====================================================================================================";
		String space = "                                                                                                    ";
		int times = 0;
		int lastTaskSize = 0;
		int lastGeralTaskSize = 0;
		float progressBefore = 0;
		AverageMobile average = new AverageMobile(500);
		while (showProgress) {
			int barSize = (int)progress % anim.length();
			int spaceSize = anim.length() - barSize;
			
			String geral = "[" + anim.substring(0, barSize) +
			space.substring(0, spaceSize)+ "] ( "+(float)Util.round(progress, 2)+"% )";
			
			barSize = (int)taskProgress % anim.length();
			spaceSize = anim.length() - barSize;
		
			String task = "[" + anim.substring(0, barSize) +
			space.substring(0, spaceSize)+ "] ( "+(float)Util.round(taskProgress, 2)+"% )" + message;
			
			String taskGeral = geral+" ("+milisToHHMMss(average.getAverage())+" restantes)";
			
			int moreSpaces = Math.max(0, lastTaskSize - task.length());
			int moreGeralSpaces = Math.max(0, lastGeralTaskSize - taskGeral.length());
			
			System.out.printf(((char) 0x1b) + "[1A\r" + "Progresso Geral: %s", taskGeral+space.substring(0, moreGeralSpaces));
			System.out.printf(((char) 0x1b) + "[1B\r" + "Progresso Task : %s ", (task + space.substring(0, moreSpaces)));
			
			lastTaskSize = task.length();
			lastGeralTaskSize = taskGeral.length();
			
			try { 
				if(times == 0){
					progressBefore = progress;
				}
				Thread.sleep(100);
				times++;
				if(times % 10 == 0){
					float elapsed = progress - progressBefore;
					float left = 100f - progress;
					estimatedTimeInMilis = elapsed > 0 ? (times * 100 * left / elapsed) : 0;
					average.addTime(estimatedTimeInMilis);
				}
				if(times > 10) times = 0;
			}catch (Exception e) {};
		}
	}	
	
	private String milisToHHMMss(float milis){
		int ss = (int) (milis / 1000f);
		int mm = (int) (milis / 60000f);
		int hh = mm / 60;
		ss %= 60;
		mm %= 60;
		return hh+" horas "+mm+" minutos "+ss+" segundos";		
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void update(float progress, float taskProgress, String message){
		this.progress = progress;
		this.taskProgress = taskProgress;
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