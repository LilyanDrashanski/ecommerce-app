package product

import com.lily.ecommerce.category.Category
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var name: String,
    var description: String,
    var price: BigDecimal,
    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category
)