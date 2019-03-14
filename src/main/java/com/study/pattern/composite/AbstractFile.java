package com.study.pattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构建
 * <p>
 * 文件夹下有（容器）：图像文件，视频文件，文本文件，子文件夹。
 */
public interface AbstractFile {
    void killVirus();//杀毒
}

/**
 * 叶子组件
 */
class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("图像文件: " + name + ",进行查杀！ ");
    }

}

class TextFile implements AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文本文件: " + name + ",进行查杀！ ");
    }

}

class VideoFile implements AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("视频文件: " + name + ",进行查杀！ ");
    }

}

/**
 * 文件夹
 */
class Folder implements AbstractFile {

    private String name;
    //定义容器，用来存放本容器构建下的子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name, List<AbstractFile> list) {
        this.name = name;
        this.list = list;
    }

    public Folder(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文件夹: " + name + "开始查杀");
        for (AbstractFile abstractFile : list) {
            //这里有一个天然的递归，如果子文件夹下，还有子文件夹，则会递归
            abstractFile.killVirus();
        }
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }
}



