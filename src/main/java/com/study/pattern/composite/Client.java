package com.study.pattern.composite;

/**
 * 使用组合模式的场景（天然的递归）:
 * 把部分和整体的关系用树形机构来表示，
 * 从而使客户端可以使用同一的方式处理部分对象和整体对象。
 * <p>
 * 资源管理器，XML文件解析，HTML解析，GUI中容器层次图,OA系统中，组织结构的处理
 *
 */
public class Client {
    public static void main(String[] args) {
        AbstractFile f2, f3, f4, f5, f6;
        Folder f1 = new Folder("我的收藏");
        f2 = new ImageFile("aaa.jpg");
        f3 = new TextFile("Hello.txt");
        f1.add(f2);
        f1.add(f3);

        f1.killVirus();
    }
}
