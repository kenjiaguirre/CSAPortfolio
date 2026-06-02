public class Main
{
    public static void main(String[] args) {
        WordMatch liberator = new WordMatch("aazz");
        System.out.println(liberator.scoreGuess("az"));
        System.out.println(liberator.scoreGuess("a"));
        System.out.println(liberator.findBetterGuess("a","z"));
        
        SingleTable Alpha = new SingleTable(4, 60, 74);
        SingleTable Bravo = new SingleTable(8, 70, 74);
        SingleTable Charlie = new SingleTable(12,75,76);
        CombinedTable Delta = new CombinedTable(Alpha, Bravo);
        System.out.println(Delta.canSeat(9));
        System.out.println(Delta.canSeat(11));
        System.out.println(Delta.getDesirability());
        
        CombinedTable Echo = new CombinedTable(Bravo,Charlie);
        System.out.println(Echo.canSeat(18));
        System.out.println(Echo.getDesirability());
        Bravo.setViewQuality(80);
        System.out.println(Echo.getDesirability());
    }
}
