package apps.soma.com.fblc.datamodels;

/**
 * Created by somaapps on 5/1/17.
 */

public class MaktabaRow {

    String rowTitle;
    int viewType = 0;

    public MaktabaRow(int vt){
        this.viewType = vt;
    }

    public MaktabaRow(String title, int vt){
        this.rowTitle   = title;
        this.viewType   = vt;
    }

    public String getRowTitle() {
        return rowTitle;
    }

    public void setRowTitle(String rowTitle) {
        this.rowTitle = rowTitle;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
