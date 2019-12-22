package concurrency.second7;

import jdk.nashorn.internal.ir.Block;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * @author Woo_home
 * @create by 2019/12/14
 * 通过 “毒丸” 对象关闭服务
 */
public class IndexingService {
    private static final File POISON = new File("");
    private final IndexerThread consumer = new IndexerThread();
    private final CrawlerThread producer = new CrawlerThread();
    private final BlockingQueue<File> queue;
    private final FileFilter fileFilter;
    private final File root;

    public IndexingService(BlockingQueue queue,FileFilter fileFilter,File root){
        this.queue = queue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    class CrawlerThread extends Thread{
        public void run() {
            try {
                crawl(root);
            }catch (InterruptedException e){
                // ignore error
            }finally {
                while (true){
                    try {
                        queue.put(POISON);
                        break;
                    }catch (InterruptedException e){
                        // ignore error
                    }
                }
            }
        }
        private void crawl(File root) throws InterruptedException{
            //...
        }
    }
    class IndexerThread extends Thread{
        public void run() {
            try {
                while (true) {
                    File file = queue.take();
                    if (file == POISON)
                        break;
                    else
                        indexFile(file);
                }
            }catch (InterruptedException e){
                // ignore error
            }
        }
        private void indexFile(File file) throws InterruptedException{
            //...
        }
    }

    public void start() {
        producer.start();
        consumer.start();
    }

    public void stop() {
        producer.interrupt();
    }

    public void awaitTermination() throws InterruptedException{
        consumer.join();
    }
}
