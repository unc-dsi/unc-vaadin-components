package nc.unc.vaadin.components.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Tag("unc-menu-separator")
@JsModule("@unc-dsi/unc-vertical-menu/unc-menu-separator.js")
@NpmPackage(value = "@unc-dsi/unc-vertical-menu", version = UncVerticalMenu.NPM_VERSION)
public class UncMenuSeparator extends Component implements MenuElement {
}
