WITH splitted AS (
    SELECT
        content_id,
        content_text AS original_text,
        regexp_split_to_table(content_text, ' ') AS word
    FROM user_content
)
SELECT
    content_id,
    original_text,
    string_agg(
        CASE
            -- Starts with a non-English letter → unchanged
            WHEN word !~ '^[a-zA-Z]'
                THEN word

            -- Hyphenated word → capitalize every part
            WHEN word ~ '^[a-zA-Z]+(-[a-zA-Z]+)+$'
                THEN initcap(word)

            -- Normal word
            ELSE
                upper(substring(word, 1, 1))
                || lower(substring(word, 2))
        END,
        ' '
    ) AS converted_text
FROM splitted
GROUP BY content_id, original_text
ORDER BY content_id;