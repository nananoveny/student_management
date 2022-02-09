package bomoncntt.svk60.vuhainguyen1851062678.helper;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import bomoncntt.svk60.vuhainguyen1851062678.R;

import bomoncntt.svk60.vuhainguyen1851062678.model.student;
import de.hdodenhof.circleimageview.CircleImageView;


public class ListAdapter extends ArrayAdapter<student> {

    private final Activity context;
    private final ArrayList<student> stulist;
    private static class ViewHolder {
        TextView txtStuid;
        TextView txtFullname;
        TextView txtSex;
        TextView txtGrade;
        ImageView croppedImageView;
    }
    public ListAdapter(Activity context, ArrayList<student> data) {
        super(context, R.layout.layout_item_sv, data);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.stulist = data;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        student dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.layout_item_sv, parent, false);
            //ánh xạ từ xml sang java
            viewHolder.txtStuid =  convertView.findViewById(R.id.item_txtStuid);
            viewHolder.txtFullname =  convertView.findViewById(R.id.itemt_txtFullname);
            viewHolder.txtSex=convertView.findViewById(R.id.item_txtSex);
            viewHolder.txtGrade=convertView.findViewById(R.id.item_txtGrade);
            viewHolder.croppedImageView=convertView.findViewById(R.id.imageViewSt);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtStuid.setText(dataModel.getStdid());
        viewHolder.txtFullname.setText(dataModel.getFullname());
        viewHolder.txtSex.setText(dataModel.getSex());
        viewHolder.txtGrade.setText(dataModel.getGrade());
        String stdpic = dataModel.getStdimage();
        Log.v("image123",stdpic);
        //convert String to image
        //set image
        viewHolder.croppedImageView.setImageBitmap(Common.StringToBitMap(stdpic));
        return convertView;

    };
}
