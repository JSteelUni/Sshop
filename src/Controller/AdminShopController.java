package Controller;

import Model.ItemRetriever;
import Model.ItemTemplate;
import View.AdminShopView;
import View.ItemPanelView;
import View.ProductDetailsView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AdminShopController {

    private AdminShopView view;

    public AdminShopController(AdminShopView view) {
        this.view = view;
        loadItems();
    }

    // reloads the shop using the database
    public void loadItems() {
        view.itemGrid.removeAll();

        //  makes an ItemTemplate list from ItemRetriever class of the database items
        for (ItemTemplate item : ItemRetriever.getAllItems()) {

            //  creates a ui panel/card
            ItemPanelView panel = new ItemPanelView(item.name, item.price);

            //  allows card to be clickable
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new ProductDetailsView(item);
                }
            });

            //  adds the cards and automatically fills them
            view.itemGrid.add(panel);
        }

        view.itemGrid.revalidate();
        view.itemGrid.repaint();
    }
}