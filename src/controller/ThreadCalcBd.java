package controller;

import java.util.concurrent.Semaphore;

public class ThreadCalcBd extends Thread {
	private int idThread;
	private Semaphore semaforo;
	long tempoCalculos;
	long tempoBD;

	public ThreadCalcBd(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	public void run() {
		comportamentoThread();
	}

	private void comportamentoThread() {
		switch (idThread % 3) {
		case 1:
			tempoCalculos = (int) ((Math.random() * 1001) + 500);
			tempoBD = 1000;
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;
		case 2:
			tempoCalculos = (int) ((Math.random() * 801) + 200);
			tempoBD = 1500;
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;
		case 0:
			tempoCalculos = (int) ((Math.random() * 1001) + 1000);
			tempoBD = 1500;
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			calculos(tempoCalculos);
			try {
				semaforo.acquire();
				BD(tempoBD);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;
		}
	}

	public void calculos(long tempoCalculos) {
		System.out.println("Thread #" + idThread + " -> Calculando ...");
		try {
			sleep(tempoCalculos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void BD(long tempoBD) {
		System.out.println("Thread #" + idThread + " -> Transacionando Banco de dados ...");
		try {
			sleep(tempoBD);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
