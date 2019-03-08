
# Task 2

## 栈 Stack

### 简介
栈是一种**线性**结构 
栈只能从一端添加且从这端取出元素，这端称为**栈顶**
**先进后出（LIFO，Last in first out）**

### 常用操作

```java
Stack<E>{
	void push(E)  // 入栈
	E pop()       // 出栈
	E peek()      // 查看栈顶元素
	int getSize()
	boolean isEmpty()
}
```

### 任务

- 用数组实现一个顺序栈
- 用链表实现一个链式栈
- 编程模拟实现一个浏览器的前进、后退功能

#### 练习
[Valid Parentheses（有效的括号）](https://leetcode-cn.com/problems/valid-parentheses/)

[Longest Valid Parentheses（最长有效的括号）](https://leetcode-cn.com/problems/longest-valid-parentheses/)

[Evaluate Reverse Polish Notatio（逆波兰表达式求值）](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)




## 队列

### 简介
队列也是是一种**线性**结构 
队列只能从**一端（队尾）**添加且从**另一端（队首）**取出元素
**先进先出（FIFO，First in first out）**

### 常用操作

```java
Queue<E>{
	void enqueue(E)	// 入队
	E dequeue()		// 出队
	E getFront()    // 查看队首元素
	int getSize()
	boolean isEmpty()
}
```

### 任务
- 用数组实现一个顺序队列

- 用链表实现一个链式队列

- 实现一个循环队列

  **循环队列中，`front == tail` 表示队列空，`(tail + 1) % capacity == front` 表示队列满。
  有一个空间是浪费的。**

#### 练习
[Design Circular Deque（设计一个双端队列）](https://leetcode-cn.com/problems/design-circular-deque/)

[Sliding Window Maximum（滑动窗口最大值）](https://leetcode-cn.com/problems/sliding-window-maximum/)



## 递归

### 任务
- 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
- 编程实现求阶乘 n!
- 编程实现一组数据集合的全排列

#### 练习
[Climbing Stairs（爬楼梯）](https://leetcode-cn.com/problems/climbing-stairs/)




## [练习题解答链接](https://github.com/SkyeLan/DataWhaleCoding/tree/master/Leetcode)