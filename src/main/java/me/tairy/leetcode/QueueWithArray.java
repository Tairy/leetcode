package me.tairy.leetcode;

/**
 * package: me.tairy.leetcode
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/23 下午8:51
 * <p>
 * 数组实现队列
 */
public class QueueWithArray {

    /**
     * 默认容量大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 初始容量
     */
    private int capacity = DEFAULT_CAPACITY;

    /**
     * 元素长度
     */
    private int length = 0;

    /**
     * 队首指针
     */
    private int front = 0;

    /**
     * 队尾指针
     */
    private int end = 0;

    /**
     * 队列容器
     */
    private int[] queue;

    /**
     * 构造函数
     *
     * @param initCapacity 初始容量
     */
    public QueueWithArray(int initCapacity) {
        if (0 != initCapacity) {
            this.capacity = initCapacity;
        }
        this.queue = new int[this.capacity];
        this.length = 0;
        this.front = 0;
        this.end = 0;
    }

    /**
     * 扩容缩容
     *
     * @param capacity 指定容量
     */
    public void resize(int capacity) {
        int[] newQueue = new int[capacity];
        int front = (this.capacity + this.front) % this.capacity;
        int end = (this.capacity + this.end) % this.capacity;
        if (end <= front) {
            end += this.capacity;
        }

        int newIndex = 0;
        for (int i = front; i < end; i++) {
            newQueue[newIndex++] = this.queue[i % this.capacity];
        }

        this.queue = null;
        this.queue = newQueue;
        this.front = 0;
        this.end = this.length;
        this.capacity = capacity;


//        this.queue = Arrays.copyOf(this.queue, capacity);
//        this.front = (this.front + this.capacity) % this.capacity;
//        this.capacity = capacity;
    }

    /**
     * lPush
     *
     * @param element 元素
     */
    public void lPush(int element) {
        if (this.length >= this.capacity) {
            resize(this.capacity * 2);
        }

        this.queue[(this.capacity + --this.front) % this.capacity] = element;
        this.length++;
    }

    /**
     * rPush
     *
     * @param element 元素
     */
    public void rPush(int element) {
        if (this.length >= this.capacity) {
            resize(this.capacity * 2);
        }
        this.queue[(this.capacity + this.end++) % this.capacity] = element;
        this.length++;
    }

    /**
     * lPop
     *
     * @return 元素
     */
    public int lPop() {
        if (this.length <= 0) {
            return 0;
        }

        if (this.length < this.capacity / 2 && this.capacity > DEFAULT_CAPACITY) {
            resize(this.capacity / 2);
        }

        int element = this.queue[(this.capacity + --this.end) % this.capacity];
        this.length--;
        return element;
    }

    /**
     * rPop
     *
     * @return 元素
     */
    public int rPop() {
        if (this.length <= 0) {
            return 0;
        }

        if (this.length < this.capacity / 2 && this.capacity > DEFAULT_CAPACITY) {
            resize(this.capacity / 2);
        }

        int element = this.queue[(this.capacity + this.front++) % this.capacity];
        this.length--;
        return element;
    }

    public void printQueueInfo() {
        System.out.printf("queue_info => capacity: %d, length: %d, front: %d, end: %d\n", this.capacity, this.length, this.front, this.end);

        int front = (this.capacity + this.front) % this.capacity;
        int end = (this.capacity + this.end) % this.capacity;
        if (end < front) {
            end += this.capacity;
        }

        for (int i = front; i < end; i++) {
            System.out.printf("%d\t", this.queue[i % this.capacity]);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        QueueWithArray queueWithArray = new QueueWithArray(16);
        int[] arr = {1, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 5, 6, 78, 8, 9, 111};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            queueWithArray.lPush(arr[i]);
//            if (i % 2 == 0) {
//                queueWithArray.lPush(arr[i]);
//            } else {
//                queueWithArray.rPush(arr[i]);
//            }
//            queueWithArray.printQueueInfo();
        }

        System.out.println("======");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(queueWithArray.rPop());

//            if (i % 2 == 0) {
//                queueWithArray.rPop();
//            } else {
//                queueWithArray.lPop();
//            }
//            queueWithArray.printQueueInfo();
        }
    }
}