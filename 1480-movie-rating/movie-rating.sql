
        (select
        u.name results
        from movierating mr
        join users u
        on mr.user_id = u.user_id
        group by u.name
        order by count(*) desc, u.name asc
        limit 1)

        union all

        (select
        m.title
        from movierating mr
        join movies m
        on mr.movie_id = m.movie_id
        where created_at >= '2020-02-01'
        and created_at <= '2020-02-29'
        group by m.title
        order by avg(rating) desc, m.title asc
        limit 1);


