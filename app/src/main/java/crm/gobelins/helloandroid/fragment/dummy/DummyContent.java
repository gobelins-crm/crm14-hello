package crm.gobelins.helloandroid.fragment.dummy;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    private static final String ITEM_PREFS = "ITEM_PREFS";
    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("2", "Item 2"));
        addItem(new DummyItem("3", "Item 3"));
        addItem(new DummyItem("4", "Item 3"));
        addItem(new DummyItem("5", "Item 3"));
        addItem(new DummyItem("6", "Item 3"));
        addItem(new DummyItem("7", "Item 3"));
        addItem(new DummyItem("8", "Item 3"));
        addItem(new DummyItem("9", "Item 3"));
        addItem(new DummyItem("10", "Item 3"));
        addItem(new DummyItem("11", "Item 3"));
        addItem(new DummyItem("12", "Item 3"));
        addItem(new DummyItem("13", "Item 3"));
        addItem(new DummyItem("14", "Item 3"));
        addItem(new DummyItem("15", "Item 3"));
        addItem(new DummyItem("16", "Item 3"));
        addItem(new DummyItem("17", "Item 3"));
        addItem(new DummyItem("18", "Item 3"));
        addItem(new DummyItem("19", "Item 3"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    public static void addAndSaveItem(Context context, DummyItem item) {
        SharedPreferences prefs = context.getSharedPreferences(ITEM_PREFS, Context.MODE_PRIVATE);
        prefs.edit()
                .putString(item.id, item.content)
                .commit();
        addItem(item);
    }

    public static void readFromPrefs(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(ITEM_PREFS, Context.MODE_PRIVATE);

        HashMap<String, String> map = (HashMap<String, String>) prefs.getAll();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            addItem(new DummyItem(entry.getKey(), entry.getValue()));
        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
