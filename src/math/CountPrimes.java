package math;

public class CountPrimes {
    public static void main(String[] args) {
        //Sieve of Eratosthenes - O(n * log(logn)) , which is less than O(n^2)(normal naive method)
        int n = 30;
        printPrimes(n);
    }

    private static void printPrimes(int n) {
        boolean[] primes = new boolean[n];

        for(int i = 2; i * i < primes.length; i++){
            if(!primes[i]){
                for(int j = i; i * j < primes.length; j++){
                    primes[i*j] = true;
                }
            }
        }

        for(int i = 2; i < primes.length;i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }

    }

}
