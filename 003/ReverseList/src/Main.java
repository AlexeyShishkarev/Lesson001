
public class Main {

    private static class List{
        private Node Head;
        private class Node{
            private int value;
            private Node next;
        }

        void Push(int value){
            Node node = new Node();
            node.value = value;
            node.next = Head;
            Head = node;
        }

        void Print(){
            Node current = Head;
            while (current != null){
                System.out.println(current.value);
                current = current.next;
            }
        }


        void Reverse(){
            if (Head.next != null){
                Node current = Head.next;
                Head.next = null;
                while (current != null){
                    Node next = current.next;
                    current.next = Head;
                    Head = current;
                    current = next;
                }
            }
        }

    }


    public static void main(String[] args) {

        List list = new List();

        list.Push(1);
        list.Push(2);
        list.Push(3);
        list.Push(4);
        list.Push(5);

        list.Print();

        System.out.println("---------------------");

        list.Reverse();
        list.Print();
    }
}