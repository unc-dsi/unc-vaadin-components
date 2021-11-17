package nc.unc.vaadin.components.menu;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Tag("unc-vertical-menu")
@JsModule("@unc-dsi/unc-vertical-menu/unc-vertical-menu.js")
@NpmPackage(value = "@unc-dsi/unc-vertical-menu", version = UncVerticalMenu.NPM_VERSION)
public class UncVerticalMenu extends Component {
    public static final String NPM_VERSION = "0.0.11";

    @Getter
    @DomEvent("select")
    public static class SelectEvent extends ComponentEvent<UncVerticalMenu> {
        private final Integer index;
        private final String label;

        public SelectEvent(
                UncVerticalMenu source,
                boolean fromClient,
                @EventData("event.detail.index") Integer index,
                @EventData("event.detail.label") String label) {
            super(source, fromClient);
            this.index = index;
            this.label = label;
        }
    }

    public UncVerticalMenu(MenuElement ... children) {
        this.add(children);
    }

    public void add(MenuElement ... children) {
        List.of(children).forEach(this::add);
    }

    public void add(MenuElement element) {
        getElement().appendChild(element.getElement());
    }

    public void addMenuItem(String label) {
        this.add(new UncMenuItem(label));
    }

    public void addMenuItem(String label, String icon) {
        this.add(new UncMenuItem(label, icon));
    }

    public void addSeparator() {
        this.add(new UncMenuSeparator());
    }

    public Registration addSelectListener(ComponentEventListener<SelectEvent> listener) {
        return addListener(SelectEvent.class, listener);
    }

    public void select(Component c) {
        c.getElement().setAttribute("selected", "");
    }

    public void selectFirst() {
        getChildren().findFirst().ifPresent(this::select);
    }
}
