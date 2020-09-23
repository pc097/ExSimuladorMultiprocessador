package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCalcBd;

public class Main {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int idThread = 1; idThread < 22; idThread++) {
			Thread thread = new ThreadCalcBd(idThread, semaforo);
			thread.start();
		}
	}
}
