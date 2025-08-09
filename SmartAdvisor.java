
public class SmartAdvisor {
    public void giveTips(double balance) {
        if(balance < 1000) {
            System.out.println("Tip: Try to maintain a minimum balance to avoid penalties.");
        } else if(balance > 100000) {
            System.out.println("Tip: Consider investing your excess funds.");
        } else {
            System.out.println("Tip: You're doing well! Keep saving.");
        }
    }
}

