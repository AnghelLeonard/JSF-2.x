package sorting.beans;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.CollectionDataModel;

public class SortDataModel<T> extends CollectionDataModel<T> {

    CollectionDataModel<T> model;
    private Integer[] rows;

    public SortDataModel(CollectionDataModel<T> model) {
        this.model = model;
        initRows();
    }

    private void initRows() {
        int rowCount = model.getRowCount();
        if (rowCount != -1) {
            this.rows = new Integer[rowCount];
            for (int i = 0; i < rowCount; ++i) {
                rows[i] = i;
            }
        }
    }

    public void sortThis(final Comparator<T> comparator) {
        Comparator<Integer> rowc = new Comparator<Integer>() {
            @Override
            public int compare(Integer key_1, Integer key_2) {
                T key_1_data = getData(key_1);
                T key_2_data = getData(key_2);
                return comparator.compare(key_1_data, key_2_data);
            }
        };
        Arrays.sort(rows, rowc);

    }

    private T getData(int row) {
        int baseRowIndex = model.getRowIndex();

        model.setRowIndex(row);
        T newRowData = model.getRowData();
        model.setRowIndex(baseRowIndex);

        return newRowData;
    }

    @Override
    public void setRowIndex(int rowIndex) {

        if ((0 <= rowIndex) && (rowIndex < rows.length)) {
            model.setRowIndex(rows[rowIndex]);
        } else {
            model.setRowIndex(rowIndex);
        }
    }

    @Override
    public boolean isRowAvailable() {
        return model.isRowAvailable();
    }

    @Override
    public int getRowCount() {
        return model.getRowCount();
    }

    @Override
    public T getRowData() {
        return model.getRowData();
    }

    @Override
    public int getRowIndex() {
        return model.getRowIndex();
    }

    @Override
    public Object getWrappedData() {
        return model.getWrappedData();
    }

    @Override
    public void setWrappedData(Object data) {
    }
}
