WITH first_orders AS (
    SELECT
        *,
        ROW_NUMBER() OVER (
            PARTITION BY customer_id
            ORDER BY order_date
        ) AS rn
    FROM delivery
)
SELECT
    ROUND(
        100.0 * COUNT(*) FILTER (
            WHERE order_date = customer_pref_delivery_date
        ) / COUNT(*),
        2
    ) AS immediate_percentage
FROM first_orders
WHERE rn = 1;