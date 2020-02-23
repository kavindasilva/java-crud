

CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL,
  `cashier` int(11) NOT NULL,
  `bill_time` datetime NOT NULL DEFAULT current_timestamp(),
  `bill_total` decimal(10,0) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `bill` (`bill_id`, `cashier`, `bill_time`, `bill_total`) VALUES
(1, 1, '2020-02-16 14:09:05', '100'),
(2, 1, '2020-02-16 14:09:05', '200');

-- --------------------------------------------------------


CREATE TABLE `bill_item` (
  `bill_item_id` int(11) NOT NULL,
  `item_batch` varchar(20) DEFAULT NULL,
  `bill_id` int(11) DEFAULT NULL,
  `qty` decimal(10,0) NOT NULL DEFAULT 1,
  `item` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `bill_item` (`bill_item_id`, `item_batch`, `bill_id`, `qty`, `item`) VALUES
(1, 'B0001', 1, '1', 1),
(2, 'B0001', 2, '1', 1);

-- --------------------------------------------------------

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1);

-- --------------------------------------------------------

CREATE TABLE `item` (
  `item_id` int(11) NOT NULL,
  `item_batch` varchar(20) NOT NULL,
  `item_name` varchar(100) NOT NULL,
  `buy_price` decimal(10,0) NOT NULL,
  `sell_price` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `item` (`item_id`, `item_batch`, `item_name`, `buy_price`, `sell_price`) VALUES
(1, 'B0001', 'test1', '100', '120'),
(2, 'B0002', 'test2', '460', '500');


ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`);

ALTER TABLE `bill_item`
  ADD PRIMARY KEY (`bill_item_id`),
  ADD KEY `FKcf0kpt07c9onbtvnttajk3skx` (`bill_id`),
  ADD KEY `FKr0qmad05u4yya14lp0tfo60i5` (`item`);

ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`);

ALTER TABLE `bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `bill_item`
  MODIFY `bill_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `item`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `bill_item`
  ADD CONSTRAINT `FKcf0kpt07c9onbtvnttajk3skx` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`),
  ADD CONSTRAINT `FKr0qmad05u4yya14lp0tfo60i5` FOREIGN KEY (`item`) REFERENCES `item` (`item_id`);
COMMIT;


-- --------------------------------------------------------

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `email`, `name`) VALUES
(1, 'someemail@someemailprovider.com', 'First'),
(2, '2.edited@gm.com', 'second-ee'),
(3, 'pkiho', '3pa33333tch'),
(4, 'ss', 'jj'),
(5, 'ff5', 'firefox'),
(6, '7@postman.com', 'dfjdf7'),
(7, '7@postman.com', 'seven'),
(8, '8.e@postman.com', 'eight'),
(11, '11.e@postman.com', 'eleven');

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

