import { CardDashboard } from "../interfaces/card-dashboard";

export const CARD_VIEW: CardDashboard[] = 
[
    {
        icon: "fa-regular fa-envelope",
        value: 0,
        label: "send emails",
        percentage: 0,
        iconColor: "text-blue-500",
        iconBackground: "bg-blue-100",
        trend: "neutral"
    },
    {
        icon: "fa-solid fa-user",
        value: 0,
        label: "contacts",
        percentage: 0,
        iconColor: "text-green-500",
        iconBackground: "bg-green-100",
        trend: "neutral"
    },
    {
        icon: "fa-regular fa-address-book",
        value: 0,
        label: "contacts group",
        percentage: 0,
        iconColor: "text-purple-500",
        iconBackground: "bg-purple-100",
        trend: "neutral"
    }
]