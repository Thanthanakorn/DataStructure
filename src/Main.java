public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(5);
        list.addFirst(4);
        list.addLast(6);
        list.addFirst(3);
        list.addLast(7);
        list.addFirst(2);
        list.addLast(8);
        list.addFirst(1);
        list.addLast(9);
        list.addFirst(0);
        list.addLast(10);
        System.out.println(list);
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        LinkedList<Integer> list2 = new LinkedList<>(list);
        System.out.println(list2);

    }
}