package com.droidconuk.frasam.preparemyorders.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.droidconuk.frasam.preparemyorders.MainActivity;
import com.droidconuk.frasam.preparemyorders.R;
import com.droidconuk.frasam.preparemyorders.adapters.ProductListAdapter;
import com.droidconuk.frasam.preparemyorders.model.Product;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;


/**
 * Created by fditrani on 25/04/15.
 */
@EFragment(R.layout.fragment_listview)
public class ProductListFragment extends Fragment {

    @InstanceState
    @FragmentArg
    ArrayList<Product> productList;

    @ViewById
    ListView fragmentListView;

    String fragmenType = "product_list";

    ProductListAdapter adapter;

    ProductListFragmentListener mListener;


    @AfterViews
    public void onCreate(){

        mListener = (ProductListFragmentListener)getActivity();

        setAdapterToListview();

        setListnersToListView();

    }

    public interface ProductListFragmentListener{

        public void onProductFragmentItemClick(Product product);

        public void onProductFragmentItemLongClick(Product product);

//        public Observable<Boolean> genericDialog(Context context, int title, int message);



    }

    private void setListnersToListView() {
        fragmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Product product = (Product)adapterView.getItemAtPosition(position);
                mListener.onProductFragmentItemClick(product);
            }
        });


        fragmentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Product product = (Product)adapterView.getItemAtPosition(position);
                mListener.onProductFragmentItemLongClick(product);
                return true;
            }
        });
    }



    private void setAdapterToListview() {

        adapter = new ProductListAdapter(getActivity(),productList );

        fragmentListView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
//        ((MainActivity)getActivity()).removeFromConditions(fragmenType);
        super.onDestroy();

    }

    public void refreshAdapterWithList(ArrayList<Product> productList){
        this.productList = productList;
        adapter = new ProductListAdapter(getActivity(),productList );
        fragmentListView.setAdapter(adapter);
    }
}
