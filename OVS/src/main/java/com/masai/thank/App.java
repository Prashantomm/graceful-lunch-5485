package com.masai.thank;

import com.masai.ui.MainUI;

public class App {
	
	    public static void main( String[] args ){
	    	
	    	System.out.println("\u001B[32m"+"╔══════════════════════════════╗");
			System.out.println("║  Online Voting System        ║");
			System.out.println("╚══════════════════════════════╝"+"\u001B");
			MainUI.mainMenu();
			System.out.println("╔══════════════════════════════╗");
			System.out.println("║   	Thanking You	       ║");
			System.out.println("╚══════════════════════════════╝");
			
			MainUI.sc.close();
			
	    }
	

}
