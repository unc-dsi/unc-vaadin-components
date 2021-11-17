package nc.unc.vaadin.components.wizard;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collection;

@Tag("unc-wizard")
@JsModule("@unc-dsi/unc-wizard/unc-wizard.js")
@NpmPackage(value = "@unc-dsi/unc-wizard", version = UncWizard.NPM_VERSION)
@NoArgsConstructor
public class UncWizard extends Component {
    public static final String NPM_VERSION = "0.0.8";

    public UncWizard(UncWizardPage ... pages) {
        this(Arrays.asList(pages));
    }

    public UncWizard(Collection<UncWizardPage> pages) {
        pages.forEach(this::add);
    }

    public void add(UncWizardPage ... pages) {
        var element = getElement();
        Arrays.stream(pages)
                .map(UncWizardPage::getElement)
                .forEach(element::appendChild);
    }

    public void next() {
        this.getElement().callJsFunction("next");
    }

    public void previous() {
        this.getElement().callJsFunction("previous");
    }
}
