package concurrency;

import java.io.IOException;

public class Process {
	public static void main(String[] args) throws IOException, InterruptedException {
		java.lang.Process p = new ProcessBuilder("notepad.exe", "D:\file.ext").start();
		Thread.sleep(1000);
		p.destroy();
	}
}
