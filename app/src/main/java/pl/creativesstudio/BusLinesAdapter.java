package pl.creativesstudio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
/**
 * @file BusLinesAdapter.java
 * @brief Adapter for displaying bus lines in a RecyclerView.
 *
 * This adapter binds a list of bus lines to a RecyclerView, handling the creation and
 * binding of view holders. It also manages user interactions with individual bus lines
 * through a click listener interface.
 *
 * @version 1.0
 * @since 2024-12-16
 */
public class BusLinesAdapter extends RecyclerView.Adapter<BusLinesAdapter.ViewHolder> {
    /**
     * List of bus lines to be displayed in the RecyclerView.
     */
    private final List<String> busLines;
    /**
     * Listener for handling click events on bus lines.
     */
    private final OnLineClickListener listener;
    /**
     * @interface OnLineClickListener
     * @brief Interface for handling bus line click events.
     *
     * This interface should be implemented by classes that wish to respond to
     * click events on individual bus lines within the RecyclerView.
     */
    public interface OnLineClickListener {
        /**
         * Called when a bus line is clicked.
         *
         * @param line The bus line that was clicked.
         */
        void onLineClick(String line);
    }
    /**
     * Constructs a new BusLinesAdapter.
     *
     * @param busLines List of bus lines to display.
     * @param listener Listener for handling click events on bus lines.
     */
    public BusLinesAdapter(List<String> busLines, OnLineClickListener listener) {
        this.busLines = busLines;
        this.listener = listener;
    }
    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent an item.
     *
     * This method inflates the item layout and creates the ViewHolder.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View for an item.
     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }
    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * This method updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String line = busLines.get(position);
        holder.textView.setText(line);
        holder.itemView.setOnClickListener(v -> listener.onLineClick(line));
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of bus lines.
     */
    @Override
    public int getItemCount() {
        return busLines.size();
    }
    /**
     * @class ViewHolder
     * @brief ViewHolder class for BusLinesAdapter.
     *
     * This inner class holds the views for each bus line item in the RecyclerView.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * TextView that displays the bus line.
         */
        TextView textView;
        /**
         * Constructs a new ViewHolder.
         *
         * @param itemView The view representing a single bus line item.
         */
        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
