package hust.dsai.soict.aims.screen;

import hust.dsai.soict.aims.exception.Quick;
import hust.dsai.soict.aims.media.Media;
import hust.dsai.soict.aims.media.Playable;
import hust.dsai.soict.cart.Cart;
import hust.dsai.soict.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

public class CartScreenController {
    private JFrame parentFrame;
    private Cart cart;
    private Store store;
    private FilteredList<Media> filteredData;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filters;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label lblTotal;


    public CartScreenController(Cart cart, JFrame parentFrame, Store store){
        super();
        this.cart = cart;
        this.store = store;
        this.parentFrame = parentFrame;
    }

    @FXML
    void initialize(){
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("price"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>(){

                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                    if(newValue!=null){
                        updateButtonBar(newValue);
                    }
                }
            });
        filteredData = new FilteredList<>(cart.getItemOrdered(), p -> true);
        tblMedia.setItems(filteredData);
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            applyFilter();
        });
        filters.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            applyFilter();
        });

        updateTotal();

        cart.getItemOrdered().addListener(
                (ListChangeListener<Media>) change -> {
                    updateTotal();
                }
        );



    }

    void applyFilter() {
        String filterText = tfFilter.getText().toLowerCase();

        filteredData.setPredicate(media -> {
            // Nếu không có chữ, hiển thị tất cả
            if (filterText == null || filterText.isEmpty()) {
                return true;
            }

            // Kiểm tra xem RadioButton nào đang được chọn
            RadioButton selectedRadio = (RadioButton) filters.getSelectedToggle();

            if (selectedRadio == radioBtnFilterId) {
                return String.valueOf(media.getId()).contains(filterText);
            } else {
                return media.getTitle().toLowerCase().contains(filterText);
            }
        });
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnOrderPressed(ActionEvent event){
        if(cart.getItemOrdered().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Rỏ hàng trống");
            alert.showAndWait();
            return;
        }
        cart.clearCart();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Đã đặt hàng thành công");
        alert.showAndWait();
        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Quick.CSARuns(() -> {
            cart.removeMedia(media.getId());
        });
        if(cart.getItemOrdered().isEmpty()) {
            btnRemove.setVisible(false);
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event){
        Playable media = (Playable)tblMedia.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Xem trước");
        alert.setHeaderText(null);
        Quick.CSARuns(() -> {
            alert.setContentText(media.play());
            alert.showAndWait();
        });
    }

    @FXML
    void viewStore(ActionEvent event) {
        parentFrame.dispose();
        new StoreScreen(store,cart);
    }

    @FXML
    void addDVD(ActionEvent event){
        parentFrame.dispose();

        new AddDVDToStoreScreen(store,cart);
    }

    @FXML
    void addCD(ActionEvent event){
        parentFrame.dispose();

        new AddCDToStoreScreen(store,cart);
    }

    @FXML
    void addBook(ActionEvent event){
        parentFrame.dispose();

        new AddBookToStoreScreen(store,cart);
    }

    @FXML
    void viewCart(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Bạn đang ở trong cart");
        alert.showAndWait();
    }

    void updateTotal() {
        float total = 0;
        for(Media media : cart.getItemOrdered()) {
            total += media.getPrice();
        }
        lblTotal.setText(String.format("%.2f $", total));
    }
}
