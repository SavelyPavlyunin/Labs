import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WarehouseTransfer {

    static class LoadingZone {
        private int currentWeight = 0;
        private final int MAX_WEIGHT = 150;

        public synchronized void loadItem(int itemWeight) {
            if (currentWeight + itemWeight > MAX_WEIGHT) {
                System.out.println(Thread.currentThread().getName() + " инициирует отправку! Вес: " + currentWeight + " кг. Едем на другой склад...");
                try { Thread.sleep(500); } catch (InterruptedException e) {}
                currentWeight = 0;
            }
            currentWeight += itemWeight;
            System.out.println(Thread.currentThread().getName() + " загрузил товар весом " + itemWeight + " кг. В фургоне сейчас: " + currentWeight + " кг.");
        }

        public synchronized void sendRemaining() {
            if (currentWeight > 0) {
                System.out.println("Финальная отправка остатков на другой склад. Вес: " + currentWeight + " кг.");
                currentWeight = 0;
            }
        }
    }

    static class TransferTask extends RecursiveAction {
        private static final int THRESHOLD = 3;
        private int[] items;
        private int start;
        private int end;
        private LoadingZone zone;

        public TransferTask(int[] items, int start, int end, LoadingZone zone) {
            this.items = items;
            this.start = start;
            this.end = end;
            this.zone = zone;
        }

        @Override
        protected void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    zone.loadItem(items[i]);
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                }
            } else {
                int mid = start + (end - start) / 2;
                TransferTask leftTask = new TransferTask(items, start, mid, zone);
                TransferTask rightTask = new TransferTask(items, mid, end, zone);
                invokeAll(leftTask, rightTask);
            }
        }
    }

    public static void main(String[] args) {
        int[] goods = {30, 40, 50, 60, 20, 10, 80, 40, 50, 70, 30, 90, 20, 15, 45, 60};
        LoadingZone loadingZone = new LoadingZone();

        ForkJoinPool pool = new ForkJoinPool(3);
        TransferTask task = new TransferTask(goods, 0, goods.length, loadingZone);

        pool.invoke(task);
        loadingZone.sendRemaining();

        System.out.println("Все товары успешно перенесены на другой склад!");
    }
}
