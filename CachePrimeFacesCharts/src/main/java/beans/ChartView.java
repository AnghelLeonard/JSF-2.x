package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.component.output.Cache;
import org.omnifaces.component.output.cache.CacheFactory;
import org.omnifaces.util.Components;
import org.omnifaces.util.Faces;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named
@ViewScoped
public class ChartView implements Serializable {

    private LineChartModel lineModel;
    private List<String> keys;
    private String selected;

    @PostConstruct
    public void init() {
        configureCache("none", true, false);
        keys = new ArrayList<>();
        createLineModels();
    }

    public void redrawAction() {
        configureCache("none", true, false);
        createLineModels();
    }

    public void saveChart() {
        String key = "key_" + new Random().nextInt(1000);
        configureCache(key, false, true);
        keys.add(key);
    }

    public void loadChart() {
        if (selected != null) {
            configureCache(selected, false, false);
        }
    }

    public void deleteChart() {
        if (selected != null) {
            CacheFactory.getCache(Faces.getContext(), "session").remove(selected);
            keys.remove(selected);
            configureCache("none", true, false);            
            resetLineModels();
        }
    }

    private void configureCache(String key, boolean disabled, boolean reset) {
        Cache cache = Components.findComponent("cacheId");
        cache.setDisabled(disabled);
        cache.setReset(reset);
        cache.setKey(key);
    }
    
    private void resetLineModels(){        
        lineModel.getSeries().clear();
    }

    private void createLineModels() {
        lineModel = initLinearModel();
        lineModel.setTitle("Linear Chart");
        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");

        Random rnd = new Random();

        series1.set(rnd.nextInt(10), rnd.nextInt(10));
        series1.set(rnd.nextInt(10), rnd.nextInt(10));
        series1.set(rnd.nextInt(10), rnd.nextInt(10));
        series1.set(rnd.nextInt(10), rnd.nextInt(10));
        series1.set(rnd.nextInt(10), rnd.nextInt(10));

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");

        series2.set(rnd.nextInt(10), rnd.nextInt(10));
        series2.set(rnd.nextInt(10), rnd.nextInt(10));
        series2.set(rnd.nextInt(10), rnd.nextInt(10));
        series2.set(rnd.nextInt(10), rnd.nextInt(10));

        model.addSeries(series1);
        model.addSeries(series2);
        return model;
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    public List<String> getKeys() {
        return keys;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
