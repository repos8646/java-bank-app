package bank.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
	
	private String ano;
	private String owner;
	private int balance;
	
	public Account(String ano, String owner, int balance) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}

public class BankApp {
	private static Scanner scanner = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	
	public static void main(String[] args) {
		
		boolean run = true;
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.println("선택> ");
			
			int selectNo = 0;
				try {
					selectNo = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					continue;
				}
				if(selectNo == 1) {
					createAccount();
				}else if(selectNo == 2) {
					accountList();
				}else if(selectNo == 3) {
					deposit();
				}else if(selectNo == 4) {
					withdraw();
				}else if(selectNo == 5) {
					run = false;
				}
		}
		System.out.println("프로그램 종료");
	}
	
	private static void createAccount() {
		System.out.println("------------------계좌생성-----------------");
		System.out.println("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.println("계좌주: ");
		String owner = scanner.nextLine();
		System.out.println("초기입금액: ");
		int balance = scanner.nextInt();
		
		Account account = new Account(ano, owner, balance);
		accounts.add(account);
		System.out.println("결과: 계좌가 생성되었습니다.");
	}
	
	private static void accountList() {
		System.out.println("------------------계좌목록-----------------");
		for(Account account : accounts) {
			System.out.print(account.getAno());
			System.out.print(" " + account.getOwner());
			System.out.print(" " + account.getBalance() + "\n");
		}
	}
	
	private static void deposit() {
		System.out.println("-------------------예금------------------");
		System.out.println("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.println("예금액: ");

		int money = 0;
	    try {
	        money = Integer.parseInt(scanner.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println("유효한 숫자를 입력하세요.");
	        return;
	    }

	    Account account = findAccount(ano);
	    if (account != null) {
	        account.setBalance(account.getBalance() + money);
	        System.out.println("결과: 예금이 성공되었습니다.");
	        System.out.println("현재 잔액: " + account.getBalance());
	    } else {
	        System.out.println("결과: 계좌를 찾을 수 없습니다.");}
		
	}
	private static void withdraw() {
		System.out.println("-------------------출금------------------");
		System.out.println("계좌번호: ");
		String ano = scanner.nextLine();
		System.out.println("출금액: ");
		
		int money = 0;
	    try {
	        money = Integer.parseInt(scanner.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println("유효한 숫자를 입력하세요.");
	        return;
	    }

	    Account account = findAccount(ano);
	    if (account != null) {
	        account.setBalance(account.getBalance() - money);
	        System.out.println("결과: 출금이 성공되었습니다.");
	        System.out.println("현재 잔액: " + account.getBalance());
	    } else {
	        System.out.println("결과: 계좌를 찾을 수 없습니다.");}
	}
	
	private static Account findAccount(String ano) {
		System.out.println("------------------계좌목록-----------------");
		for(Account account : accounts) {
			if(account.getAno().equals(ano)) {
				return account;
			}
		}
		return null;
	}
}
