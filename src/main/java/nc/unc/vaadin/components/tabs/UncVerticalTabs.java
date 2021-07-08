package nc.unc.vaadin.components.tabs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Tag("unc-vertical-tabs")
@JsModule("@unc-dsi/unc-vertical-tabs/unc-vertical-tabs.js")
@NpmPackage(value = "@unc-dsi/unc-vertical-tabs", version = UncVerticalTabs.VERSION)
public class UncVerticalTabs extends Component {
    public static final String VERSION = "0.0.6";

    public UncVerticalTabs(UncVerticalTab ... tabs) {
        List.of(tabs).forEach(this::addTab);
    }

    public UncVerticalTabs addTab(UncVerticalTab tab) {
        this.getElement().appendChild(tab.getElement());
        return this;
    }
}
