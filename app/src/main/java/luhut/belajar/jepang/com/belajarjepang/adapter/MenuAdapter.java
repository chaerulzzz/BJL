package luhut.belajar.jepang.com.belajarjepang.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import luhut.belajar.jepang.com.belajarjepang.R;
import luhut.belajar.jepang.com.belajarjepang.model.MenuModel;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuModel> menuList;
    private onItemClickListener listener;
    private onSpeakerClicked speakerListener;
    private boolean clicked;

    public MenuAdapter(List<MenuModel> menuList, onItemClickListener listener, onSpeakerClicked listener2){
        this.listener = listener;
        this.menuList = menuList;
        this.speakerListener = listener2;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.materi_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        final MenuModel menu = menuList.get(position);
        holder.mImage.setImageDrawable(menu.getmImage());
        holder.mTitle.setText(menu.getTitle());
        holder.mContent.setText(menu.getContent());

        holder.bind(menu, listener);

        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listener.onItemClick(menu);
            }
        };

        holder.mSpeaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clicked = !clicked;

                speakerListener.onSpeakerClick(menu.getCodeS(), clicked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle, mContent;
        ImageView mImage;
        RelativeLayout mSpeaker;

        ViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.materi_menu_title);
            mContent = itemView.findViewById(R.id.materi_menu_content);
            mImage = itemView.findViewById(R.id.materi_menu_image);
            mSpeaker = itemView.findViewById(R.id.materi_menu_speaker);
        }

        void bind(final MenuModel menu, final onItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(menu);
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(MenuModel menu);
    }

    public interface onSpeakerClicked{
        void onSpeakerClick(String code, boolean clicked);
    }
}
