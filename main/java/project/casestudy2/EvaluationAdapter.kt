package project.casestudy2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import project.casestudy2.model.Metric

class EvaluationAdapter(
    private val list: List<Metric>
) : RecyclerView.Adapter<EvaluationAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView =
            itemView.findViewById(R.id.txtMetricName)

        val value: TextView =
            itemView.findViewById(R.id.txtMetricValue)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_metric,
                parent,
                false
            )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {

        holder.title.text = list[position].title
        holder.value.text = list[position].value

    }

    override fun getItemCount(): Int {

        return list.size

    }
}