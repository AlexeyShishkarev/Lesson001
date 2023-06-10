// Урок 4. Структуры данных дерево и хэш-таблица
// Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.

// Красно-черное дерево имеет следующие критерии:
// • Каждая нода имеет цвет (красный или черный)
// • Корень дерева всегда черный
// • Новая нода всегда красная
// • Красные ноды могут быть только левым ребенком
// • У краной ноды все дети черного цвета

// Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, 
// благодаря которой все критерии выше станут валидными. Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.


public class Main {

    public static class BinaryTree{
        private Node root;
        private class Node{
            int value;
            Node leftChild;
            Node rightChild;
            Color color;
        }

        private enum Color{
            RED, BLACK
        }

        public boolean add(int value){
            if (root != null){
                boolean result = addNode(root, value);
                root = rebalance(root);
                root.color = Color.BLACK;
                return result;
            } else {
                root = new Node();
                root.color = Color.BLACK;
                root.value = value;
                return true;
            }
        }

        private boolean addNode (Node node, int value){
            if (node.value == value){
                return false;
            } else {
                if (node.value > value) {
                    if (node.leftChild != null) {
                        boolean result = addNode(node.leftChild, value);
                        node.leftChild = rebalance(node.leftChild);
                        return result;
                    } else {
                        node.leftChild = new Node();
                        node.leftChild.color = Color.RED;
                        node.leftChild.value = value;
                        return true;
                    }
                }else{
                        if (node.rightChild != null){
                            boolean result = addNode(node.rightChild, value);
                            node.rightChild = rebalance(node.rightChild);
                            return result;
                        } else {
                            node.rightChild = new Node();
                            node.rightChild.color = Color.RED;
                            node.rightChild.value = value;
                            return true;
                    }
                }
            }

        }

        private void colorSwap(Node node){
            node.rightChild.color = Color.BLACK;
            node.leftChild.color = Color.BLACK;
            node.color = Color.RED;
        }

        private Node leftSwap(Node node){
            Node leftChild = node.leftChild;
            Node betweenChild = leftChild.rightChild;
            leftChild.rightChild = node;
            node.leftChild = betweenChild;
            leftChild.color = node.color;
            node.color = Color.RED;
            return leftChild;
        }

        private Node rightSwap(Node node){
            Node rightChild = node.rightChild;
            Node betweenChild = rightChild.leftChild;
            rightChild.leftChild = node;
            node.rightChild = betweenChild;
            rightChild.color = node.color;
            node.color = Color.RED;
            return rightChild;
        }

        private Node rebalance(Node node){
            Node result = node;
            boolean needRebalance;
            do {
                needRebalance = false;
                if (result.rightChild != null && result.rightChild.color == Color.RED &&
                        (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
                }
                if (result.leftChild != null && result.leftChild.color == Color.RED &&
                        result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                    needRebalance = true;
                    result = leftSwap(result);
                }
                if (result.leftChild != null && result.leftChild.color == Color.RED &&
                result.rightChild != null && result.rightChild.color == Color.RED) {
                    needRebalance = true;
                    colorSwap(result);
                }
            }
            while (needRebalance);
            return result;
        }

    }



    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(9);
        tree.add(8);





    }
}
