package guitests.guihandles;

import org.controlsfx.control.StatusBar;

import javafx.scene.Node;

/**
 * A handle for the {@code StatusBarFooter} at the footer of the application.
 */
public class StatusBarFooterHandle extends NodeHandle<Node> {
    public static final String STATUS_BAR_PLACEHOLDER = "#statusbarPlaceholder";

    private static final String SYNC_STATUS_ID = "#syncStatus";
    private static final String SAVE_LOCATION_STATUS_ID = "#saveLocationStatus";
    private static final String TOTAL_NUMBER_STATUS_ID = "#totalNumberStatus";

    private final StatusBar syncStatusNode;
    private final StatusBar saveLocationNode;
    private final StatusBar totalNumberNode;

    private String lastRememberedSyncStatus;
    private String lastRememberedSaveLocation;
    private String lastRememberedTotalNumber;

    public StatusBarFooterHandle(Node statusBarFooterNode) {
        super(statusBarFooterNode);

        syncStatusNode = getChildNode(SYNC_STATUS_ID);
        saveLocationNode = getChildNode(SAVE_LOCATION_STATUS_ID);
        totalNumberNode = getChildNode(TOTAL_NUMBER_STATUS_ID);
    }

    /**
     * Returns the text of the sync status portion of the status bar.
     */
    public String getSyncStatus() {
        return syncStatusNode.getText();
    }

    /**
     * Returns the text of the 'save location' portion of the status bar.
     */
    public String getSaveLocation() {
        return saveLocationNode.getText();
    }
    /**
     * Returns the text of the 'total number of people' portion of the status bar.
     */
    public String getTotalNumberStatus() {
        return totalNumberNode.getText();
    }

    /**
     * Remembers the content of the sync status portion of the status bar.
     */
    public void rememberSyncStatus() {
        lastRememberedSyncStatus = getSyncStatus();
    }

    /**
     * Returns true if the current content of the sync status is different from the value remembered by the most recent
     * {@code rememberSyncStatus()} call.
     */
    public boolean isSyncStatusChanged() {
        return !lastRememberedSyncStatus.equals(getSyncStatus());
    }

    /**
     * Remembers the content of the 'save location' portion of the status bar.
     */
    public void rememberSaveLocation() {
        lastRememberedSaveLocation = getSaveLocation();
    }

    /**
     * Returns true if the current content of the 'save location' is different from the value remembered by the most
     * recent {@code rememberSaveLocation()} call.
     */
    public boolean isSaveLocationChanged() {
        return !lastRememberedSaveLocation.equals(getSaveLocation());
    }

    /**
     * Remembers the content of the total number status portion of the status bar.
     */
    public void rememberTotalNumberStatus() {
        lastRememberedTotalNumber = getTotalNumberStatus();
    }

    /**
     * Returns true if the current content of the sync status is different from the value remembered by the most recent
     * {@code rememberSyncStatus()} call.
     */
    public boolean isTotalNumberStatusChanged() {
        return !lastRememberedTotalNumber.equals(getTotalNumberStatus());
    }
}
